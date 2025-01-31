clc
close all
clear all

pkg image load

image_peppers = imread('peppers.png');
image_moon = imread('moon.tif');
h_laplace = fspecial('laplacian', 0.2);
image_peppers_sharpened = imfilter(image_peppers, h_laplace);
image_moon_sharpened = imfilter(image_moon, h_laplace);
h_unsharp = fspecial('unsharp', 0.5);
image_peppers_unsharp = imfilter(image_peppers, h_unsharp);
image_moon_unsharp = imfilter(image_moon, h_unsharp);

figure;
subplot(2, 3, 1), imshow(image_peppers), title('Oryginalny obraz Peppers');
subplot(2, 3, 2), imshow(image_peppers_sharpened), title('Peppers - Laplace');
subplot(2, 3, 3), imshow(image_peppers_unsharp), title('Peppers - Unsharp');
subplot(2, 3, 4), imshow(image_moon), title('Oryginalny obraz Moon');
subplot(2, 3, 5), imshow(image_moon_sharpened), title('Moon - Laplace');
subplot(2, 3, 6), imshow(image_moon_unsharp), title('Moon - Unsharp');

