clc
close all
clear all

pkg load image;

img = imread('images_04.jpg');

if size(img, 3) == 3
  img = rgb2gray(img);
end

binary_img = im2bw(img);
filled_img = imfill(binary_img, 'holes');
se = ones(3);
smoothed_img = imerode(imdilate(filled_img, se), se);

figure;
subplot(1, 3, 1), imshow(img), title('Oryginalny gray obraz');
subplot(1, 3, 2), imshow(binary_img), title('Oryginalny obraz binarny');
subplot(1, 3, 3), imshow(filled_img), title('Po wypełnieniu dziur');
subplot(1, 3, 4), imshow(smoothed_img), title('Po wygładzeniu brzegów');


