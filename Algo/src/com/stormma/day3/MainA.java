package com.stormma.day3;
import java.util.Scanner;
public class MainA
{

	/**
	 * @param args
	 */
	public static boolean flag = false;
	public static int n, m;
	public static int x1, x2, y1, y2;
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		//(x1,y1)和(x2,y2)
		while (scan.hasNext())
		{
			n = scan.nextInt();
			m = scan.nextInt();
			int [][] map = new int [1005][1005];
			if (n == 0 && m == 0)
			{
				System.exit(0);
			}
			/**
			 * 初始化地图
			 */
			for (int i = 1; i <= n; i++)
			{
				for (int j = 1; j <= m; j++)
				{
					map[i][j] = scan.nextInt();
				}
			}
			//输入次数
			int time = scan.nextInt();
			//开始操作
			while ((time--) > 0)
			{
				flag = false;
				int [][] vis = new int [1005][1005];
				x1 = scan.nextInt();
				y1 = scan.nextInt();
				x2 = scan.nextInt();
				y2 = scan.nextInt();
				//如果是同一个坐标的话
				if (x1 == x2 && y1 == y2 || map[x1][y1] == 0)
				{
					System.out.println("NO");
				}
				//不同坐标的值相同，并且都不为0
				else if ((map[x1][y1] == map[x2][y2]) && map[x1][y1] != 0)
				{
					//上搜
					dfs(map,vis,x1-1,y1,1,0);  
					//下
	                dfs(map,vis,x1+1,y1,2,0);  
	                dfs(map,vis,x1,y1-1,3,0);  
	                dfs(map,vis,x1,y1+1,4,0); 
	                if (flag)
	                {
	                	System.out.println("YES");
	                }
	                else
	                {
	                	System.out.println("NO");
	                }
				}
				else
					System.out.println("NO");
			}
		}
	}
	/**
	 * @param x：横坐标
	 * @param y：纵坐标
	 * @param dir：朝向(1:up,2:down,3:left,4right)
	 * @param count：拐弯次数
	 * @return
	 */
	public static void dfs (int [][] map, int [][] vis, int x, int y, int dir, int count)
	{
		//如果找到了的话
		if (flag)
			return;
		//转弯次数大于2，直接丢掉
		if (count > 2)
			return;
		//如果越界的话，丢掉
		if(x<=0 || y<=0 || x>n || y>m) 
		    return ; 
		if(x == x2 && y == y2)//找到了  
	    {  
	        flag = true;  
	        return ;  
	    } 
		if(count == 2)//剪枝，转弯两次时，看目的点的坐标与现在的朝向是否在一个方向上，不在的话就返回  
	    {  
	        if(!(dir == 1 && x > x2 && y == y2 || dir == 2 && x<x2 && y == y2 || dir == 3 && y>y2 && x==x2 || dir == 4 && y < y2 && x == x2))  
	        return;  
	    } 
		if(map[x][y]!=0) 
			return;  
	    if(vis[x][y] != 0) 
	    	return ;  
	    vis[x][y] = 1;  
	    if(dir == 1)//上  
	    {  
	        dfs(map,vis,x-1,y,1,count);  
	        dfs(map,vis,x+1,y,2,count+1);  
	        dfs(map,vis,x,y-1,3,count+1);  
	        dfs(map,vis,x,y+1,4,count+1);  
	    }  
	    else if(dir == 2)//下  
	    {  
	        dfs(map,vis,x-1,y,1,count+1);  
	        dfs(map,vis,x+1,y,2,count);  
	        dfs(map,vis,x,y-1,3,count+1);  
	        dfs(map,vis,x,y+1,4,count+1);  
	    }  
	    else if(dir == 3)//左  
	    {  
	        dfs(map,vis,x-1,y,1,count+1);  
	        dfs(map,vis,x+1,y,2,count+1);  
	        dfs(map,vis,x,y-1,3,count);  
	        dfs(map,vis,x,y+1,4,count+1);  
	    }  
	    else if(dir == 4)//右  
	    {  
	        dfs(map,vis,x-1,y,1,count+1);  
	        dfs(map,vis,x+1,y,2,count+1);  
	        dfs(map,vis,x,y-1,3,count+1);  
	        dfs(map,vis,x,y+1,4,count);  
	    }  
	    vis[x][y] = 0;  
	}
}
