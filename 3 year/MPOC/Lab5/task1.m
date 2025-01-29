clc
close all
clear all

pkg image load

image = imread('moon.tif');
image_gaussian = imnoise(image, 'gaussian', 0, 0.01);
image_salt_pepper = imnoise(image, 'salt & pepper', 0.05);
image_speckle = imnoise(image, 'speckle', 0.05);
image_poisson = imnoise(image, 'poisson');

figure;
subplot(2, 3, 1);
imshow(image);
title('Oryginalny obraz');

subplot(2, 3, 2);
imshow(image_gaussian);
title('Szum Gaussian');

subplot(2, 3, 3);
imshow(image_salt_pepper);
title('Szum Salt & Pepper');

subplot(2, 3, 4);
imshow(image_speckle);
title('Szum Speckle');

subplot(2, 3, 5);
imshow(image_poisson);
title('Szum Poisson');


imwrite(image_gaussian, 'image_gaussian.tif');
imwrite(image_salt_pepper, 'image_salt_pepper.tif');
imwrite(image_speckle, 'image_speckle.tif');
imwrite(image_poisson, 'image_poisson.tif');
