/**
*@author StormMaybin
*@Date 2016-07-17 
*/
# include <stdio.h>
const int MAXN = 50;
int queue[MAXN] = {0};
int main (void)
{
	int n, front, rear;
	scanf ("%d",&n);
	for (int i = 0; i < n; i++)
	{
		queue[i] = i + 1;
	}
	front = 0;
	rear = n;
	while (front < rear)
	{
		printf ("%d ", queue[front++]);
		queue[rear++] = queue[front++];
		printf("\n");
		printf ("%d %d", front, rear);
	} 
	printf("\nrearµÄÖµÊÇ£º");
	printf("\n%d ",rear);
	return 0;
} 
