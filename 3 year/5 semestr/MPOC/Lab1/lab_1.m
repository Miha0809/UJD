clc
close all
clear all

%ZAD1-2:


A=imread('autumn.tif');
imshow(A);
title('autumn')
imwrite(A,'autumn.jpeg','jpeg')
imwrite(A,'autumn.bmp','bmp')

figure

C=imread('lenaRGB.tiff');
imshow(C);
title('Lena')
imwrite(C,'lenaRGB.jpeg','jpeg')
imwrite(C,'lenaRGB.bmp','bmp')

figure
%{
B=imread('foto08.BMP');
imshow(B);
title('Men')
imwrite(B,'foto08.jpeg','jpeg')
imwrite(B,'foto08.tiff','tiff')

figure

D=imread('4.2.07.BMP');
imshow(D);
title('Paprika')
imwrite(D,'4.2.07.jpeg','jpeg')
imwrite(D,'4.2.07.tiff','tiff')

figure

E=imread('4.2.06.BMP');
imshow(E);
title('The boat')
imwrite(E,'4.2.06.jpeg','jpeg')
imwrite(E,'4.2.06.tiff','tiff')

figure

F=imread('4.2.03.BMP');
imshow(F);
title('The monkey')
imwrite(F,'4.2.03.jpeg','jpeg')
imwrite(F,'4.2.03.tiff','tiff')

figure

G=imread('4.1.06.tiff');
imshow(G);
title('Tree')
imwrite(G,'4.1.06.jpeg','jpeg')
imwrite(G,'4.1.06.bmp','bmp')

figure

H=imread('4.1.06.jpg');
imshow(H);
title('Tree2')
imwrite(H,'4.1.06.tiff','tiff')
imwrite(H,'4.1.06.bmp','bmp')

figure

I=imread('4.1.05.BMP');
imshow(I);
title('The house')
imwrite(I,'4.1.05.jpeg','jpeg')
imwrite(I,'4.1.05.tiff','tiff')

figure

J=imread('kids.tif');
imshow(J);
title('Kids')
imwrite(J,'kids.jpeg','jpeg')
imwrite(J,'kids.bmp','bmp')

figure

K=imread('canoe.tif');
imshow(K);
title('Canoe')
imwrite(K,'canoe.jpeg','jpeg')
imwrite(K,'canoe.bmp','bmp')

figure

L=imread('LENA256.BMP');
imshow(L);
title('LENA256')
imwrite(L,'LENA256.jpeg','jpeg')
imwrite(L,'LENA256.tiff','tiff')




%ZAD3:

obrazki = {'autumn.tif', 'lenaRGB.tiff', '4.2.07.BMP', '4.2.06.BMP', ...
           '4.2.03.BMP', '4.1.06.tiff', '4.1.06.jpg', '4.1.05.BMP', 'kids.tif', ...
           'canoe.tif', 'LENA256.BMP','foto08.BMP'};

for i = 1:length(obrazki)
    [m, map] = imread(obrazki{i});
    fprintf('Obraz %s: ', obrazki{i})

    if ndims(m) == 3
        disp('Obraz jest trójwymiarowy')
    elseif ndims(m) == 2 && size(map,1)==0
        disp('Obraz jest czarno-biały')
    elseif size(map,1)>0
        disp('Obraz jest indeksowany')
    end
end



%ZAD4:

obrazki = {'autumn.tif', 'lenaRGB.tiff', '4.2.07.BMP', '4.2.06.BMP', ...
           '4.2.03.BMP', '4.1.06.tiff', '4.1.06.jpg', '4.1.05.BMP', 'kids.tif', ...
           'canoe.tif', 'LENA256.BMP', 'foto08.BMP'};
for i = 1:length(obrazki)
    [M, map] = imread(obrazki{i});

    if ndims(M) == 3
        Ir = double(M(:, :, 1)) / 255;
        Ig = double(M(:, :, 2)) / 255;
        Ib = double(M(:, :, 3)) / 255;

        Igray = (Ir + Ig + Ib) / 3;
    else
        Igray = M;
    end
    figure;
    subplot(1, 2, 1), imshow(M, map), title('Oryginalny obraz:');
    subplot(1, 2, 2), imshow(Igray), title('Obraz w skali szarości:');
end



%ZAD5:

obrazki = {'autumn.tif', 'lenaRGB.tiff', '4.2.07.BMP', '4.2.06.BMP', ...
           '4.2.03.BMP', '4.1.06.tiff', '4.1.06.jpg', '4.1.05.BMP', 'kids.tif', ...
           'canoe.tif', 'LENA256.BMP', 'foto08.BMP'};
for i = 1:length(obrazki)
    [M, map] = imread(obrazki{i});

    if ndims(M) == 3
        Ir = double(M(:, :, 1)) / 255;
        Ig = double(M(:, :, 2)) / 255;
        Ib = double(M(:, :, 3)) / 255;

        Igray = (11 * Ir + 16 * Ig + 5 * Ib) / 32;
    else
        Igray = M;
    end
    figure;
    subplot(1, 2, 1), imshow(M, map), title('Oryginalny obraz:');
    subplot(1, 2, 2), imshow(Igray), title('Obraz w skali szarości(z uwzględnieniem czułości oka):');
end



%ZAD6 NA ODRĘBNYM PLIKU

%ZAD7:
obrazki = {'4.2.06.jpeg','4.1.05.BMP','autumn.tif'};

for i = 1:length(obrazki)
  [I, map] = imread(obrazki{i});
  if ndims(I) == 3
      Ir = I;
      Ir(:,:,2:3)=0;

      Ig = I;
      Ig(:,:,1)=0; Ig(:,:,3)=0;

      Ib = I;
      Ib(:,:,1:2)=0;

      figure

      subplot(2, 2, 1); imshow(I); title('Obraz oryginalny:');
      subplot(2, 2, 2); imshow(Ir); title('Składowa R:');
      subplot(2, 2, 3); imshow(Ig); title('Składowa G:');
      subplot(2, 2, 4); imshow(Ib); title('Składowa B:');
  else
      disp('Obraz nie jest trójwymiarowy')
  end
end%ZAD8:
I = imread('foto08.BMP');
I_horizontal_flip = flipud(I);
I_vertical_flip = fliplr(I);

figure;
subplot(1, 3, 1); imshow(I); title('Oryginalny obraz:');
subplot(1, 3, 2); imshow(I_horizontal_flip); title('Odbicie w pionie:');
subplot(1, 3, 3); imshow(I_vertical_flip); title('Odbicie w poziomie:');


imwrite(I_horizontal_flip, 'horizontal_flip.png');
imwrite(I_vertical_flip, 'vertical_flip.png');




%ZAD9(NIE GOTOWE)

% Wczytaj obraz
I = imread('foto08.BMP'); % Upewnij się, że plik jest w odpowiedniej lokalizacji

% Trzykrotne powiększenie
scale_factor = 3;
new_size = size(I) * scale_factor;

% Powiększenie przy użyciu różnych metod
I_nearest = imresize(I, new_size, 'nearest');
I_bilinear = imresize(I, new_size, 'bilinear');
I_bicubic = imresize(I, new_size, 'bicubic');

% Pomniejszenie powiększonych obrazów do rozmiarów oryginalnych
I_nearest_down = imresize(I_nearest, size(I), 'nearest');
I_bilinear_down = imresize(I_bilinear, size(I), 'bilinear');
I_bicubic_down = imresize(I_bicubic, size(I), 'bicubic');

% Obraz różnicowy
diff_nearest = imabsdiff(I, I_nearest_down);
diff_bilinear = imabsdiff(I, I_bilinear_down);
diff_bicubic = imabsdiff(I, I_bicubic_down);

% Wyświetlanie wyników
figure;

subplot(3, 3, 1); imshow(I); title('Obraz oryginalny');
subplot(3, 3, 2); imshow(I_nearest); title('Pow. - Najbliżsi sąsiedzi');
subplot(3, 3, 3); imshow(diff_nearest); title('Różnica - Najbliżsi sąsiedzi');

subplot(3, 3, 4); imshow(I_bilinear); title('Pow. - Dwuliniowa');
subplot(3, 3, 5); imshow(I_bilinear_down); title('Pomniejszony - Dwuliniowa');
subplot(3, 3, 6); imshow(diff_bilinear); title('Różnica - Dwuliniowa');

subplot(3, 3, 7); imshow(I_bicubic); title('Pow. - Dwukwadratowa');
subplot(3, 3, 8); imshow(I_bicubic_down); title('Pomniejszony - Dwukwadratowa');
subplot(3, 3, 9); imshow(diff_bicubic); title('Różnica - Dwukwadratowa');

%ZAD10:
% Wczytaj obraz
I = imread('foto08.BMP'); % Upewnij się, że plik jest w odpowiedniej lokalizacji

% Powiększenie metodą powielania kolumn i wierszy
[rows, cols, channels] = size(I);
I_replicated = zeros(rows * 2, cols * 2, channels, 'uint8'); % Tworzenie nowego obrazu

% Powielanie pikseli
I_replicated(1:2:end, 1:2:end, :) = I; % Powielanie pikseli

% Powiększenie metodą interpolacji liniowej
I_interpolated = imresize(I, 2, 'linear'); % Użycie interpolacji liniowej

% Wyświetlanie obrazów
figure;
subplot(1, 3, 1); imshow(I); title('Obraz oryginalny');
subplot(1, 3, 2); imshow(I_replicated); title('Powiększenie - Powielanie');
subplot(1, 3, 3); imshow(I_interpolated); title('Powiększenie - Interpolacja liniowa');
%}
