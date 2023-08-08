#include <stdio.h>

int main() {
    int N, M;
    scanf("%d %d", &N, &M);

    int arr[N];
    int sum = 0;

    scanf("%d", &sum);
    arr[0] = sum;

    for (int i = 1; i < N; i++)
    {
        int now = 0;
        scanf("%d", &now);
        sum += now;
        arr[i] = sum;
    }

    for (int i = 0; i < M; i ++)
    {
        int start, end;
        scanf("%d %d", &start, &end);

        if(start == 1) {
            printf("%d\n",arr[end-1]);
        } else {
            printf("%d\n",arr[end-1] - arr[start-2]);
        }
    }
}