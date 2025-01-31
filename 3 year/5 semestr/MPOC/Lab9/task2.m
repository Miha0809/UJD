clc
close all
clear all

pkg image load;

function binary_img = progowanieBW(img, t1, t2)
  binary_img = (img >= t1) & (img <= t2);
end

img = imread('two.BMP');
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

binary_img = progowanieBW(img, t1, t2);

figure(3);
imshow(binary_img);
title(['Obraz po progowaniu (', num2str(t1), ' - ', num2str(t2), ')']);

