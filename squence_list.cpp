/**
*@author StormMaybin
*@Date 2016-07-15 
*/ 
# include <stdio.h>
# include <malloc.h>
# include <stdlib.h>

# define MAXSIZE 100
typedef int datatype;
//结构体的定义 
typedef struct list
{
	datatype a[MAXSIZE]; 
   	int size; 
}sequence_list;
//初始化 
void init_sequence_list(sequence_list *slt)
{  
    slt->size=0;  
}  
//尾部插值 
void insert_sequence_list(sequence_list *slt,datatype x)  
{  
    if(slt->size == MAXSIZE)
	{  
    	printf("FULL!\n");  
    	exit(1);  
    }  
    slt->size=slt->size+1;  
    slt->a[slt->size]=x;  
}  
//打印
void print_sequence_list(sequence_list * slt)  
{  
       int i;  
       if(slt->size == 0)   
            printf("\nThe list is empty!\n");  
       else  
            for(i=1;i<=slt->size;i++)    
                printf("%d ",slt->a[i]);  
}   
//判断是否为空
int is_empty_sequence_list(sequence_list * slt)  
{  
     return(slt->size == 0 ? 0:1);  
}  
//查找节点为x的位置 
int find_num_sequence_list(sequence_list * slt,datatype x)  

{  
       int i=0;  
       while(slt->a[i]!=x && i<slt->size)   
            i++;  
       return(i<slt->size? i:-1);  
}   
//取位置为i的节点 
datatype get_data_pos(sequence_list * slt,int i)  
{  
       if(i < 0 || i >= slt->size)  
       {
             printf("The position dese not exist!\n");
             exit(1);
        }  
       else  
             return slt->a[i];  
}
//在位置position处插入
int main(void)
{
	sequence_list * slt;
	//先开始初始化
	init_sequence_list(slt);
	//开始插值
	insert_sequence_list(slt, 5);
	insert_sequence_list(slt, 6);
	//开始打印
	print_sequence_list(slt); 
	return 0;
} 
