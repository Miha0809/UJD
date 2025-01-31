clc
close all
clear all

pkg image load

img = imread('office_1.jpg');

if size(img, 3) == 3
    img = rgb2gray(img);
end

img_adjusted_default = imadjust(img);
low_in = 0.1;
high_in = 0.9;
low_out = 0;
high_out = 1;
img_adjusted_range = imadjust(img, [low_in; high_in], [low_out; high_out]);
gamma_value = 0.8;
img_adjusted_gamma = imadjust(img, [low_in; high_in], [low_out; high_out], gamma_value);

figure;
subplot(2, 2, 1), imshow(img), title('Obraz oryginalny');
subplot(2, 2, 2), imshow(img_adjusted_default), title('Obraz po imadjust (domyślne)');
subplot(2, 2, 3), imshow(img_adjusted_range), title('Obraz po zmianie zakresu intensywności');
subplot(2, 2, 4), imshow(img_adjusted_gamma), title('Obraz po zmianie gamma (rozjaśnianie)');

