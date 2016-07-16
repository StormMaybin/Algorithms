/**
*@author StormMaybin
*@Date 2016-07-17 
*/
# include <stdio.h>
const int MAXN = 1000 + 10;
int n, target[MAXN];

int main (void)
{
	while (scanf("%d",&n) == 1)
	{
		int stack[MAXN];
		int top = 0;
		int A = 1;
		int B = 1;
		for (int i = 1; i <= n; i++)
		{
			scanf ("%d", &target[i]);
		}
		int ok = 1;
		while (B <= n)
		{
			if (A == target[B])
			{
				A++;
				B++;
			}
			else if (top && stack[top] == target[B])
			{
				top--;
				B++;
			}
			else if (A <= n)
			{
				stack[++top] = A++;
			}
			else
			{
				ok = 0;
				break;
			}
		}
		printf ("%s\n",ok ? "Yes" : "No");
	}
	return 0;
} 
