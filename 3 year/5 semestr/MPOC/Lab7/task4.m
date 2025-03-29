clc
close all
clear all

pkg image load

img6 = imread('Obraz_06a.jpg');
img6_adjusted = imadjust(img6);
imwrite(img6_adjusted, 'image6_adjusted.jpg');

figure;
subplot(2, 1, 1), imshow(img6), title('Oryginał');
subplot(2, 1, 2), imshow(img6_adjusted), title('img6_adjusted');
