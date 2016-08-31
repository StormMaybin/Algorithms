package com.stormma.day3;
import java.util.Scanner;
public class MainA_2
{
	public static int ax, ay, bx, by;
	public static void main(String[] args)
	{
		Scanner scan = new Scanner (System.in);
		boolean flag = false;
		while (scan.hasNext())
		{
			/**
			 * 录入行和列
			 */
			int n = scan.nextInt();
			int m = scan.nextInt();
			int [][] map = new int [n+1][m+1];
			for (int i = 1; i <= n; i++)
			{
				for (int j = 1; j <= m; j++)
				{
					map[i][j] = scan.nextInt();
				}
			}
			//标记数组
			int time = scan.nextInt();
			while ((time--) > 0)
			{
				//先初始化标记
				flag = false;
				ax = scan.nextInt();
				ay = scan.nextInt();
				bx = scan.nextInt();
				by = scan.nextInt();
				int [][] vis = new int [n+1][m+1];
				//开始判断
				if (ax == bx && ay == by || map[ax][ay] == 0 || map[ax][ay] != map[bx][by])
				{
					System.out.println("NO");
				}
				else
				{
					dfs(flag,map,vis,ax-1,ay,1,0,n,m);  
	                dfs(flag,map,vis,ax+1,ay,2,0,n,m);  
	                dfs(flag,map,vis,ax,ay-1,3,0,n,m);  
	                dfs(flag,map,vis,ax,ay+1,4,0,n,m);
	                if (flag)
	                {
	                	System.out.println("YES");
	                }
	                else
	                {
	                	System.out.println("NO");
	                }
				}
			}
		}
	}
	public static void dfs (boolean flag,int [][] map, int [][]vis, int x, int y, int dir, int count, int n, int m)
	{
		if (flag)
			return ;
		if (count > 2)//如果已经转弯超过两次的话
			return ;
		if(x<=0 || y<=0 || x>n || y>m) //越界的话
		    return ; 
		if(x == bx && y == by)//找到了  
	    {  
	        flag = true;  
	        return ;  
	    } 
		if (count == 2)
		{
			//剪枝，转弯两次时，看目的点的坐标与现在的朝向是否在一个方向上，不在的话就返回  
		    if(!(dir == 1 && x > bx && y == by || dir == 2 && x < bx && y == by || dir == 3 && y > by && x == bx || dir == 4 && y < by && x == bx))  
		    	return;  
		}
		if(map[x][y]!=0) 
			return;  
		if(vis[x][y] != 0) //表明已经走过一次了，所以不用再搜索了
	    	return ;  
		 vis[x][y] = 1;  
		 if(dir == 1)//上  
		 {  
		     dfs(flag,map,vis,x-1,y,1,count,n,m);  
		     dfs(flag,map,vis,x+1,y,2,count+1,n,m);  
		     dfs(flag,map,vis,x,y-1,3,count+1,n,m);  
		     dfs(flag,map,vis,x,y+1,4,count+1,n,m);  
		 }  
		 else if (dir == 2)
		 {
			 dfs(flag,map,vis,x-1,y,1,count+1,n,m);  
		     dfs(flag,map,vis,x+1,y,2,count,n,m);  
		     dfs(flag,map,vis,x,y-1,3,count+1,n,m);  
		     dfs(flag,map,vis,x,y+1,4,count+1,n,m);  
		 }
		 else if (dir == 3)
		 {
			 dfs(flag,map,vis,x-1,y,1,count+1,n,m);  
		     dfs(flag,map,vis,x+1,y,2,count+1,n,m);  
		     dfs(flag,map,vis,x,y-1,3,count,n,m);  
		     dfs(flag,map,vis,x,y+1,4,count+1,n,m);  
		 }
		 else if (dir == 4)
		 {
			 dfs(flag,map,vis,x-1,y,1,count+1,n,m);  
		     dfs(flag,map,vis,x+1,y,2,count+1,n,m);  
		     dfs(flag,map,vis,x,y-1,3,count+1,n,m);  
		     dfs(flag,map,vis,x,y+1,4,count,n,m);  
		 }
		 vis[x][y] = 0;  
	}
}
