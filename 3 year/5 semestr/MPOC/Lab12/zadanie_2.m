clc
close all
clear all
pkg image load

image = imread('Krwinki.jpg');

if size(image, 3) == 3
  image_gray = rgb2gray(image);
else
  image_gray = image;
end

th = graythresh(image_gray) * 255;
Im = image_gray < th;
Im = imopen(Im, ones(3));
Im = imfill(Im, 'holes');

[L, num] = bwlabel(Im);
props = regionprops(L, 'Area', 'BoundingBox');
mean_area = mean([props.Area]);
filtered_objects = 0;

figure
subplot(4, 2, 1);imshow(image);title('Oryginalny obraz');
subplot(4, 2, 2);imshow(image_gray, []);title('Obraz w skali szarości');
subplot(4, 2, 3);imshow(Im);title('Po progowaniu i operacjach morfologicznych');
subplot(4, 2, 4);imshow(label2rgb(L, 'jet', 'k', 'shuffle'));title('Etykietowanie');
subplot(4, 2, 5);imshow(image);title('Wykryto krwinki');

hold on;
for k = 1:num
  area = props(k).Area;
  bbox = props(k).BoundingBox;

  if (area > 0.8 * mean_area && area < 1.2 * mean_area) && ...
     (bbox(1) > 1 && bbox(2) > 1 && bbox(1) + bbox(3) <= size(image_gray, 2) && ...
      bbox(2) + bbox(4) <= size(image_gray, 1))
     filtered_objects = filtered_objects + 1;
     rectangle('Position', bbox, 'EdgeColor', 'r', 'LineWidth', 0.5);
  end
end
hold off;

fprintf(['Liczba czerwonych krwinek w całości na obrazie wynosi: ', num2str(filtered_objects)]);

imwrite(image_gray, 'krwinki_gray.jpg');
imwrite(Im, 'krwinki_opermorfolog.jpg');
