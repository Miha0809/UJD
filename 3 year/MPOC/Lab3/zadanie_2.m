clc
close all
clear all

pkg load image



#zad 2

function obraz_roznicowy(x,y)

  image1 = imread(x);
  image2 = imread(y);

  [rows, cols, ~] = size(image1);
  image2_resized = imresize(image2, [rows, cols]);

  gray1 = rgb2gray(image1);
  gray2 = rgb2gray(image2_resized);

  difference = imabsdiff(gray1, gray2);

  difference_normalized = mat2gray(difference);

  figure;
  subplot(1, 3, 1);
  imshow(gray1);
  title('Obraz 1 (skala szarości)');

  subplot(1, 3, 2);
  imshow(gray2);
  title('Obraz 2 (skala szarości)');

  subplot(1, 3, 3);
  imshow(difference_normalized, []);
  title('Różnice');
end;



obraz_roznicowy('big-ben-london1.png','big-ben-london2.png');
obraz_roznicowy('leaning-tower-pisa-italy1.png','leaning-tower-pisa-italy2.png');
obraz_roznicowy('paris-france-eiffel-tower1.png','paris-france-eiffel-tower2.png');
obraz_roznicowy('san-francisco-golden-gate-difference-FIND0320-5de1c2e1986f4a3890bfb119d891b9721.png','san-francisco-golden-gate-difference-FIND0320-5de1c2e1986f4a3890bfb119d891b9722.png');
obraz_roznicowy('sydney-australia-opera-harbor1.png','sydney-australia-opera-harbor2.png');
