clc
close all
clear all

pkg load image

#Zad1:



%image1

img = imread('tire.tif');
if size(img, 3) == 3
    img=rgb2gray(img);
end

img = double(img) / 255;
factor = 0.5;
img_scaled_clipped = img * factor;
img_scaled_clipped(img_scaled_clipped > 1) = 1;
img_scaled_clipped(img_scaled_clipped < 0) = 0;
img_scaled_clipped = uint8(img_scaled_clipped * 255);
img_scaled_normalized = img * factor;
img_scaled_normalized = img_scaled_normalized / max(img_scaled_normalized(:));
img_scaled_normalized = uint8(img_scaled_normalized * 255);

figure;

subplot(1,3,1);
imshow(uint8(img * 255));
title('Oryginalny obraz');

subplot(1,3,2);
imshow(img_scaled_clipped);
title('Metoda1: Obcinanie');

subplot(1,3,3);
imshow(img_scaled_normalized);
title('Metoda2: Znormalizowanie');



%image2

img = imread('moon.tif');
if size(img, 3) == 3
    img=rgb2gray(img);
end

img = double(img) / 255;
factor = 0.5;
img_scaled_clipped = img * factor;
img_scaled_clipped(img_scaled_clipped > 1) = 1;
img_scaled_clipped(img_scaled_clipped < 0) = 0;
img_scaled_clipped = uint8(img_scaled_clipped * 255);
img_scaled_normalized = img * factor;
img_scaled_normalized = img_scaled_normalized / max(img_scaled_normalized(:));
img_scaled_normalized = uint8(img_scaled_normalized * 255);

figure;

subplot(1,3,1);
imshow(uint8(img * 255));
title('Oryginalny obraz');

subplot(1,3,2);
imshow(img_scaled_clipped);
title('Metoda1: Obcinanie');

subplot(1,3,3);
imshow(img_scaled_normalized);
title('Metoda2: Znormalizowanie');


