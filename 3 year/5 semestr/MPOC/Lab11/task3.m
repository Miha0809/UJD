clc
close all
clear all

pkg load image;

img = imread('images_3.jpg');

if size(img, 3) == 3
  img = rgb2gray(img);
end

binary_img = im2bw(img);
border_mask = imdilate(binary_img, ones(3)) & binary_img;
cleaned_img = binary_img & ~border_mask;

figure;
subplot(1, 3, 1), imshow(img), title('Oryginalny gray obraz');
subplot(1, 3, 2), imshow(binary_img), title('Oryginalny obraz binarny');
subplot(1, 3, 3), imshow(border_mask), title('Obiekty stykajace sie z brzegiem');
subplot(1, 3, 4), imshow(cleaned_img), title('Po usunieciu obiektów');

