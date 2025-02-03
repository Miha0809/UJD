clc
close all
clear all

pkg load image;

function segmented_img = wieloprogowanie(img, thresholds)
  segmented_img = zeros(size(img));
  for i = 1:length(thresholds) - 1
    mask = (img >= thresholds(i)) & (img < thresholds(i + 1));
    segmented_img(mask) = i * (255 / (length(thresholds) - 1));
  end
end

img = imread('four.BMP');
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

disp('Kliknij na histogramie wartości progowe (ENTER, aby zakończyć).');
[x, ~] = ginput();
thresholds = round(sort([0; x; 255]));

segmented_img = wieloprogowanie(img, thresholds);

figure(3);
imshow(segmented_img, []);
title('Obraz po wieloprogowaniu');


