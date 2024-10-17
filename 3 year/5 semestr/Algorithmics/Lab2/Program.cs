// Task2
Console.WriteLine("\t\t\t\tTask2");
var bfs = new BFS();

var el1 = new Node(1);
var el2 = new Node(2);
var el3 = new Node(3);
var el4 = new Node(4);
var el5 = new Node(5);
var el6 = new Node(6);

bfs.AddEdge(el1, el2);
bfs.AddEdge(el1, el3);
bfs.AddEdge(el3, el4);
bfs.AddEdge(el3, el5);
bfs.AddEdge(el3, el6);

bfs.Search();
bfs.ToString();

var el7 = new Node(7);
var el8 = new Node(8);

bfs.AddEdge(el1, el7);
bfs.AddEdge(el1, el8);

bfs.ToString();
