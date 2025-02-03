clc
close all
clear all

pkg load image;

img = imread('images_2.jpg');

if size(img, 3) == 3
  img = rgb2gray(img);
end

binary_img = im2bw(img);

distance_transform = bwdist(~binary_img);
watershed_transform = watershed(-distance_transform);
segmented_img = binary_img;
segmented_img(watershed_transform == 0) = 0;

figure;
subplot(1, 3, 1), imshow(img), title('Oryginalny gray obraz');
subplot(1, 3, 2), imshow(binary_img), title('Oryginalny obraz binarny');
subplot(1, 3, 3), imshow(distance_transform, []), title('Transformata odległości');
subplot(1, 3, 4), imshow(segmented_img), title('Po rozdzieleniu obiektów');



