clc;
clear all;
close all;
pkg load image;



%Zadanie1

img1 = imread('kola.png');
img2 = imread('LENA256.BMP');
imwrite(img2,'LENA256.png','png')
img1 = imresize(img1, size(img2));

o_img = img1 .* img2;
imshow(o_img), title("Lena i kola")
imwrite(o_img,'wynik.png');

figure

I = imread('kola.png');
I = uint8(I) * 255;
negatyw_I = 255 - I;
subplot(1,2,1), imshow(I), title('Oryginalny obraz');
subplot(1,2,2), imshow(negatyw_I), title('Negatyw obrazu kola.png');
imwrite(negatyw_I,'negatyw_kola.png');

M = imread('LENA256.BMP');
imwrite(M,'LENA256.png','png');
L = imread('kola.png');
L = uint8(L) * 255;
L = rgb2gray(L);
L1 = L(1:size(M, 2), 1:size(M, 2));
Iout = bitand(M, L1);
figure; imshow(Iout); title('AND');

return;



%Zadanie2

img1 = imread('kola.png');
img2 = imread('LENA256.BMP');

imwrite(img2,'LENA256.png','png')

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
negatyw_I = 255 - img1;

sum_img = bitor(img2, img1);
imshow(sum_img);
imwrite(sum_img, 'suma_z_kolem.png');

sum_neg_img = bitor(img2, negatyw_img1);
imshow(sum_neg_img);
imwrite(sum_neg_img, 'suma_z_negatywem_kola.png');

figure;
subplot(2, 2, 1), imshow(img2), title('Oryginalny obraz LENA');
subplot(2, 2, 2), imshow(img1), title('Oryginalny obraz kola');
subplot(2, 2, 3), imshow(sum_img), title('Suma logiczna LENA i koło');
subplot(2, 2, 4), imshow(sum_neg_img), title('Suma logiczna LENA i negatyw koła');

img1 = imread('kola.png');
img1 = img1 * 255;
img2 = imread('LENA256.BMP');
img1 = imresize(img1, size(img2));

img2(:, :, 2)=img2;
img2(:, :, 3)= img2(:, :, 2);

img1 = uint8(img1);
img2 = uint8(img2);

sum_img = bitor(img2, img1);

imshow(sum_img);

