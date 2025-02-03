clc
close all
clear all

pkg image load

img4 = imread('Obraz_04a.jpg');
img4_gray = rgb2gray(img4);
img4_contrast = imadjust(img4_gray);

figure;
subplot(2, 1, 1), imshow(img4), title('Oryginał');
subplot(2, 1, 2), imshow(img4_contrast), title('Obraz 4 - Poprawiony kontrast');

