clc
close all
clear all
pkg image load

image = imread('bakterie.jpg');

figure
imshow(image);title('Oryginalny');

if size(image, 3) == 3
  imagegray = rgb2gray(image);
else
  imagegray=image;
end

th = 150;
Im = imagegray > th;

figure
imshow(Im);title('Po progowaniu');
imwrite(Im, 'bakterie_poprogowaniu.jpg');

Mask = ones(3);
Imorf = imopen(Im, Mask);
Imorf = imfill(Imorf, 'holes');

figure
imshow(Imorf);title('Po operacjach morfologicznych');
imwrite(Imorf,'bakterie_poopermorfologicznych.jpg');

[L, num] = bwlabel(Imorf);
fprintf('liczba obiektow: ');
fprintf(num2str(num));

props = regionprops(L,'Orientation');
imagegray = cat(3, imagegray, imagegray, imagegray);

for k = 1:num
  orientation = props(k).Orientation;
  if abs(orientation) < 15
    mask = (L == k);
    outline = bwperim(mask);
    imagegray(:,:,1) = imagegray(:,:,1) + uint8(outline) * 255;
    imagegray(:,:,2) = imagegray(:,:,2) - uint8(outline) * 255;
    imagegray(:,:,3) = imagegray(:,:,3) - uint8(outline) * 255;
  end
end

figure
imshow(imagegray);
title('Obiekty poziome obwodzie czerwonym');
imwrite(image, 'bakterie_obwodzie.jpg');
