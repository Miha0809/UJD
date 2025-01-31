clc
close all
clear all

pkg image load

img5 = imread('Obraz_05a.png');
img5_gray = rgb2gray(img5);
img5_brightness_adjusted = img5_gray + 50;
imwrite(img5_brightness_adjusted, 'image5_brightness_adjusted.jpg');

figure;
subplot(2, 1, 1), imshow(img5), title('Oryginał');
subplot(2, 1, 2), imshow(img5_brightness_adjusted), title('image5_brightness_adjusted');


