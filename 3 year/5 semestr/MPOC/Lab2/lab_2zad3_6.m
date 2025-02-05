clc;
clear all;
close all;
pkg load image;


%Zadanie3

img1 = imread('śnieg.jpg');
img2 = imread('lena256.bmp');

if size(img1, 3) ~= size(img2, 3)
    img2 = repmat(img2(:, :, 1), [1, 1, size(img1, 3)]);
end
img1 = imresize(img1, [size(img2, 1), size(img2, 2)]);

if islogical(img1)
    img1 = uint8(img1) * 255;
end
if islogical(img2)
    img2 = uint8(img2) * 255;
end

logic_sum = bitor(img1, img2);

alpha = 0.5;
beta = 0.5;
gamma = 0;
linear_comb = imlincomb(alpha, img1, beta, img2, gamma);

figure;
subplot(2, 2, 1), imshow(img1), title('Obraz 1');
subplot(2, 2, 2), imshow(img2), title('Obraz 2');
subplot(2, 2, 3), imshow(logic_sum), title('Suma logiczna');
subplot(2, 2, 4), imshow(linear_comb, []), title('Kombinacja liniowa');

imwrite(logic_sum, 'suma_logic.png');
imwrite(uint8(linear_comb), 'kombinacja_liniowa.png');




%Zadanie4
img1 = imread('lena256.bmp');
img2 = imread('śnieg.jpg');

if size(img1, 3) ~= size(img2, 3)
    img2 = repmat(img2(:, :, 1), [1, 1, size(img1, 3)]);
end
img1 = imresize(img1, [size(img2, 1), size(img2, 2)]);

if islogical(img1)
    img1 = uint8(img1) * 255;
end
if islogical(img2)
    img2 = uint8(img2) * 255;
end


xor_result = bitxor(img1, img2);

xor_result_2 = bitxor(xor_result, img1);

figure;
subplot(2, 2, 1), imshow(img1), title('Obraz 1 (Lena)');
subplot(2, 2, 2), imshow(img2), title('Obraz 2 (Rain)');
subplot(2, 2, 3), imshow(xor_result), title('Alternatywa rozłączna (XOR) Obrazów 1 i 2');
subplot(2, 2, 4), imshow(xor_result_2, []), title('Alternatywa rozłączna wyniku i Obrazu 1');

imwrite(xor_result, 'Alternatywa_rozłączna.png');
imwrite(xor_result, 'Alternatywa_rozłączna2.png');


%Zadanie5

[I, map] = imread('Ufok.bmp');
mask = I;
mask(I > 1) = 255;

mask(:,:,2) = mask;
mask(:,:,3) = mask(:,:,1);

Iufo = ind2rgb(I,map);
Iufo = uint8(Iufo * 255);

[Ibackground, map] = imread('Tlo.bmp');

Ibackground = ind2rgb(Ibackground,map);
Ibackground = uint8(Ibackground * 255);

w = size(Iufo,1);
k = size(Iufo,2);

Iout = Ibackground;

x = 200;
y = 150;

maskNeg = bitcmp(mask,8);

Iout(x:x+w-1, y:y+k-1, :) = bitand(Iout(x:x+w-1, y:y+k-1, :),maskNeg);
Iout(x:x+w-1, y:y+k-1, :) = bitor(Iout(x:x+w-1, y:y+k-1, :),Iufo);
figure;
imshow(Iout), title('Obraz wynikowy');


%Zadanie6
[I, map] = imread('Ufok.bmp');
[Ibackground, map_bg] = imread('Tlo.bmp');

Iufo = ind2rgb(I, map);
Iufo = uint8(Iufo * 255);

Ibackground = ind2rgb(Ibackground, map_bg);
Ibackground = uint8(Ibackground * 255);

mask = I;
mask(I > 0) = 255;

mask(:,:,2) = mask;
mask(:,:,3) = mask(:,:,1);

maskNeg = bitcmp(mask, 8);

w = size(Iufo, 1);
k = size(Iufo, 2) / 6;

x = 200;
y = 50;
step = 15;

figure;
for repeat = 1:5
  for klatka = 1:6
      IufoCut = Iufo(:, (klatka-1)*k + 1:klatka*k, :);
      maskCut = mask(:, (klatka-1)*k + 1:klatka*k, :);
      maskNegCut = maskNeg(:, (klatka-1)*k + 1:klatka*k, :);

      Iout = Ibackground;

      Iout(x:x+w-1, y:y+k-1, :) = bitor(bitand(Iout(x:x+w-1, y:y+k-1, :), maskNegCut), bitand(IufoCut, maskCut));

      imshow(Iout);
      title(['Klatka ', num2str(klatka)]);
      pause(0.04);

      y = y + step;
  end
end
