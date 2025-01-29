clc
close all
clear all

pkg image load

image = imread('moon.tif');
image_gaussian = imnoise(image, 'gaussian', 0, 0.01);
image_diff = imabsdiff(image, image_gaussian);
image_diff_eq = histeq(image_diff);

figure;
subplot(1, 2, 1);
imshow(image_diff);
title('Obraz różnicowy');

subplot(1, 2, 2);
imshow(image_diff_eq);
title('Obraz różnicowy po wyrównaniu histogramu');

