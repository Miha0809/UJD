clc
close all
clear all

pkg load image;

function binary_img = progowanieBW(img, threshold)
  binary_img = img > threshold;
end

img = imread('one.BMP');
if size(img, 3) == 3
  img = rgb2gray(img);
end

figure(1);
imshow(img);
title('Oryginalny obraz');

figure(2);
[counts, bins] = imhist(img);
bar(bins, counts);
title('Histogram obrazu');
xlabel('Poziomy szarości');
ylabel('Liczba pikseli');

[x, ~] = ginput(1);
threshold = round(x);

binary_img = progowanieBW(img, threshold);

figure(3);
imshow(binary_img);
title(['Obraz po progowaniu (Threshold = ', num2str(threshold), ')']);

