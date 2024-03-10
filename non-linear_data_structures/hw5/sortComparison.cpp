#include <vector>
#include <algorithm>
#include <chrono>
#include <random>
#include <iostream>
#include <fstream>
#include <numeric>

class sortComparison {
public:

    void insertionSort(std::vector<int>& numbers) {
        int n = numbers.size();

        for (int i = 1;  i < n; i++) {
            int key = numbers[i];
            int j = i -1;

            while (j >= 0 && numbers[j] >= 0) {
                numbers[j + i]  = numbers[j];
                j--;
            }
        }

    }

    void bucketSort(std::vector<int>& numbers, int numBuckets) {
        if (numbers.empty() || numBuckets <= 0) {
            return;
        }

        int minValue = *min_element(numbers.begin(), numbers.end());
        int maxValue = *max_element(numbers.begin(), numbers.end());

        double range = (maxValue - minValue + 1) / static_cast<double>(numBuckets);

        std::vector<std::vector<int>> buckets(numBuckets);

        for (int num : numbers) {
            int bucketIndex = static_cast<int>((num - minValue) / range);
            buckets[bucketIndex].push_back(num);
        }

        for (auto& bucket : buckets) {
            std::sort(bucket.begin(), bucket.end());
        }

        numbers.clear();
        for (const auto& bucket : buckets) {
            numbers.insert(numbers.end(), bucket.begin(), bucket.end());
        }
    }
    

    void radixSort(std::vector<int>& numbers) {
        if (numbers.empty()) {
            return;
        }

        int maxValue = *max_element(numbers.begin(), numbers.end());
        int exp = 1;  

        std::vector<int> temp(numbers.size());

        auto countingSort = [&numbers, &temp, &exp](int place) {
            const int size = numbers.size();
            const int range = 10;  

            std::vector<int> count(range, 0);

            for (int i = 0; i < size; ++i)
                count[(numbers[i] / place) % 10]++;

            for (int i = 1; i < range; ++i)
                count[i] += count[i - 1];

            for (int i = size - 1; i >= 0; --i) {
                temp[count[(numbers[i] / place) % 10] - 1] = numbers[i];
                count[(numbers[i] / place) % 10]--;
            }

            for (int i = 0; i < size; ++i)
                numbers[i] = temp[i];
        };

        while (maxValue / exp > 0) {
            countingSort(exp);
            exp *= 10;
        }
    }

};

//couldn't get all the wallclock and useful stuff in main working for problem D.