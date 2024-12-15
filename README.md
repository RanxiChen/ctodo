# ctodo
ctodo is a cli todo manager.Todos will be stored in file specified by Path. Now, it's on struct.
## Usage
### ctodo add "something to be done."
将一个事件加到列表里。
### ctodo done id
将列表中序号为id的事件标记为完成。

## code explain
I don't use database, do CRUD in my code after decoding info from file.

There are 3 kinds of Task:

1.todo: Task need to be done
2.done: Task had done
3.open: Task is on going
