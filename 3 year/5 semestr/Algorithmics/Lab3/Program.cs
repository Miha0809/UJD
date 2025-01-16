// Task1
GrapthAdjList task1 = new GrapthAdjList();

var el1 = new Node(1);
var el2 = new Node(2);
var el3 = new Node(3);
var el4 = new Node(4);
var el5 = new Node(5);
var el6 = new Node(6);

el1.AddEdge(el2);
el1.AddEdge(el3);
el3.AddEdge(el4);
el4.AddEdge(el5);
el2.AddEdge(el5);
el5.AddEdge(el6);

task1.DFS(el1);