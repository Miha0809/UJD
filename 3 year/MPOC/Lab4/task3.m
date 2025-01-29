clc
close all
clear all

pkg image load

function img_clipped = clip_histogram(img)
    if size(img, 3) == 3
        img = rgb2gray(img);
    end

    num_pixels = numel(img);
    sorted_pixels = sort(double(img(:)));
    lower_bound_idx = floor(0.05 * num_pixels);
    upper_bound_idx = floor(0.95 * num_pixels);
    fmin = sorted_pixels(lower_bound_idx + 1);
    fmax = sorted_pixels(upper_bound_idx);
    min_val = 0;
    max_val = 255;
    img_clipped = (double(img) - fmin) / (fmax - fmin) * (max_val - min_val) + min_val;
    img_clipped = uint8(img_clipped);
end

img = imread('office_1.jpg');

if size(img, 3) == 3
    img = rgb2gray(img);
end

img_clipped = clip_histogram(img);

figure;
subplot(1, 2, 1), imshow(img), title('Obraz oryginalny');
subplot(1, 2, 2), imshow(img_clipped), title('Obraz po obcięciu histogramu');

img2 = imread('office_6.jpg');

if size(img2, 3) == 3
    img2 = rgb2gray(img2);
end

img_clipped2 = clip_histogram(img2);

figure;
subplot(1, 2, 1), imshow(img2), title('Obraz oryginalny');
subplot(1, 2, 2), imshow(img_clipped2), title('Obraz po obcięciu histogramu');

