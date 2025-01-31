clc
close all
clear all

pkg load image;

function gray_img = progowanie2Gray(img, t1, t2, bg_color)
  mask = (img >= t1) & (img <= t2);
  gray_img = img .* mask + (1 - mask) * bg_color;
end

img = imread('three.jpg');
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

disp('Kliknij na histogramie dwie wartości progowe.');
[x, ~] = ginput(2);
t1 = round(min(x));
t2 = round(max(x));

bg_color = input('Podaj wartość tła (0 - czarny, 255 - biały): ');

gray_img = progowanie2Gray(img, t1, t2, bg_color);

figure(3);
imshow(gray_img);
title(['Obraz po progowaniu (', num2str(t1), ' - ', num2str(t2), ', bg=', num2str(bg_color), ')']);

