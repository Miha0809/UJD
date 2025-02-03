clc
close all
clear all

pkg image load

img = imread('office_1.jpg');

if size(img, 3) == 3
    img = rgb2gray(img);
end

img_eq = histeq(img);
shift_value = 50;
img_shifted = img + shift_value;
img_shifted = uint8(min(max(img_shifted, 0), 255));
img_eq_shifted = img_eq + shift_value;
img_eq_shifted = uint8(min(max(img_eq_shifted, 0), 255));

figure;
subplot(2, 2, 1), imshow(img), title('Obraz oryginalny');
subplot(2, 2, 2), imshow(img_eq), title('Obraz po wyrównaniu histogramu');
subplot(2, 2, 3), imshow(img_shifted), title('Obraz po przesunięciu histogramu');
subplot(2, 2, 4), imshow(img_eq_shifted), title('Obraz po wyrównaniu i przesunięciu');


