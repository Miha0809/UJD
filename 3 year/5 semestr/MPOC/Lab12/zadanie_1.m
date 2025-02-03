clc
close all
clear all
pkg image load

image = imread('rice.png');
image_gray = double(image);

radius = 15;
[cols, rows] = meshgrid(-radius:radius, -radius:radius);
se = sqrt(rows.^2 + cols.^2) <= radius;

background = imerode(image_gray, se);
background = imdilate(background, se);
image_gray = image_gray - background;
image_gray = mat2gray(image_gray);

threshold = graythresh(image_gray);
bw = image_gray > threshold;

bw = bwareaopen(bw, 30);
bw = imfill(bw, 'holes');

[L, num] = bwlabel(bw);
s = regionprops(L, 'Area', 'PixelIdxList');
areas = cat(1, s.Area);

[minArea, minIndex] = min(areas);
obrazmin = zeros(size(L));
obrazmin(s(minIndex).PixelIdxList) = 1;

perimeter = bwperim(obrazmin);

overlay = cat(3, image, image, image);
overlay = uint8(overlay);
redChannel = overlay(:,:,1);
greenChannel = overlay(:,:,2);
blueChannel = overlay(:,:,3);
redChannel(perimeter) = 255;
greenChannel(perimeter) = 0;
blueChannel(perimeter) = 0;

overlay(:,:,1) = redChannel;
overlay(:,:,2) = greenChannel;
overlay(:,:,3) = blueChannel;

figure;
subplot(2, 2, 1); imshow(image_gray, []); title('Po wyrównaniu tła');
subplot(2, 2, 2); imshow(bw); title('Po progowaniu i operacjach morfologicznych');
subplot(2, 2, 3); imshow(overlay); title('Najmniejszy obiekt zaznaczony otoczką');

meanArea = mean(areas);
numBelowMean = sum(areas < meanArea);

fprintf(['Całkowita liczba obiektów: ', num2str(num)]);
fprintf(['Średnia powierzchnia obiektów: ', num2str(meanArea)]);
fprintf(['Liczba obiektów mniejszych niż średnia powierzchnia: ', num2str(numBelowMean)]);

imwrite(image_gray,'rice_gray.png');
imwrite(bw,'rice_poprogowaniu_opermorfolog.png');
imwrite(overlay,'rice_najmniejszy_objekt.png');
