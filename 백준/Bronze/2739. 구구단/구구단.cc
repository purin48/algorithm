#include <stdio.h>

int main()
{
	int N = 0;

	scanf("%d", &N);

	if (0 < N && N < 10)
	{
		for (int i = 1; i < 10; i++)
		{
			printf("%d * %d = %d \n", N, i, N * i);
		}
	}
	else
	{
		printf("수를 잘못 입력");
	}
}