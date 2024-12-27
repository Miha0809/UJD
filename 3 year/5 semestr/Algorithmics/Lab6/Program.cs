int[,] graph = {
    { 0, 29, 20, 21 },
    { 29, 0, 15, 17 },
    { 20, 15, 0, 28 },
    { 21, 17, 28, 0 }
};

var bruteForce = new HamiltonianCycle(graph);
var timeStart = DateTime.UtcNow;
bruteForce.BruteForce();
var timeEnd = DateTime.UtcNow;
var bruteForceTime = timeEnd - timeStart;
Console.WriteLine(bruteForce);
Console.WriteLine("BrutForce time: " + bruteForceTime + "\n");