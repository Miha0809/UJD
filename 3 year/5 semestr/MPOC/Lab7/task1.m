clc
close all
clear all

pkg image load

img1 = imread('Obraz_01a.png');
img2 = imread('Obraz_02a.png');
img3 = imread('Obraz_03a.png');

img1_filtered = medfilt2(img1, [3 3]);
img2_filtered = medfilt2(img2, [3 3]);
img3_filtered = medfilt2(img3, [3 3]);

imwrite(img1_filtered, 'image1_filtered.jpg');
imwrite(img2_filtered, 'image2_filtered.jpg');
imwrite(img3_filtered, 'image3_filtered.jpg');

figure;
subplot(3, 3, 1), imshow(img1), title('Image1 Oryginał');
subplot(3, 3, 2), imshow(img2), title('Image2 Oryginał');
subplot(3, 3, 3), imshow(img3), title('Image3 Oryginał');
subplot(3, 3, 4), imshow(img1_filtered), title('img1_filtered');
subplot(3, 3, 5), imshow(img2_filtered), title('img2_filtered');
subplot(3, 3, 6), imshow(img3_filtered), title('img3_filtered');
