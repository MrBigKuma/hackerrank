package weekofcode38

// package main
import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
	"strings"
	"container/heap"
)

// Complete the cyclicalQueries function below.
func cyclicalQueries(w []int64, m int32, queries []string) []int64 {
	// Return the list of answers to all queries of type 4. Take the query information from standard input.
	nodes := make([]*PriorityQueue, len(w))
	for i := 0; i < len(w); i++ {
		queue := make(PriorityQueue, 0)
		nodes[i] = &queue
		heap.Init(nodes[i])
	}

	var results []int64
	for qIdx := int32(0); qIdx < m; qIdx++ {
		q := strings.Split(queries[qIdx], " ")
		xTmp, err := strconv.ParseInt(q[1], 10, 32)
		checkError(err)
		x := int(xTmp - 1)

		switch q[0][0] {
		case '1':
			{
				newW, err := strconv.ParseInt(q[2], 10, 64)
				checkError(err)
				farthestIdx, _ := findFarthestNode(x, w, nodes)
				var queue = nodes[farthestIdx]
				if len(*queue) == 0 {
					node := &NewNode{accW: newW, qIdx: qIdx}
					heap.Push(queue, node)
				} else {
					node := &NewNode{accW: (*queue)[0].accW + newW, qIdx: qIdx}
					heap.Push(queue, node)
				}
			}

		case '2':
			{
				newW, err := strconv.ParseInt(q[2], 10, 64)
				checkError(err)
				node := &NewNode{accW: newW, qIdx: qIdx}
				heap.Push(nodes[x], node)
			}

		case '3':
			{
				farthestIdx, _ := findFarthestNode(x, w, nodes)
				heap.Pop(nodes[farthestIdx])
			}

		case '4':
			{
				_, farthestDist := findFarthestNode(x, w, nodes)
				results = append(results, farthestDist)
			}
		}
	}

	return results
}

func findFarthestNode(x int, w []int64, nodes []*PriorityQueue) (int, int64) {
	n := len(w)
	farthestIdx := x
	farthestDist := int64(0)
	origNodeDist := int64(0)
	for i := x; i < x+n; i++ {
		idx := i % n
		maxDistFromNode := int64(0)
		if len(*nodes[idx]) > 0 {
			maxDistFromNode = (*nodes[idx])[0].accW
		}

		var dist = origNodeDist + maxDistFromNode
		if dist > farthestDist {
			farthestIdx = idx
			farthestDist = dist
		}
		origNodeDist += w[idx]
	}
	// fmt.Println(x, farthestIdx, farthestDist)
	return farthestIdx, farthestDist
}

type PriorityQueue []*NewNode

func (pq PriorityQueue) Len() int { return len(pq) }

func (pq PriorityQueue) Less(i, j int) bool {
	// We want Pop to give us the highest, not lowest, priority so we use greater than here.
	if pq[i].accW == pq[j].accW {
		return pq[i].qIdx > pq[j].qIdx
	}
	return pq[i].accW > pq[j].accW
}

func (pq PriorityQueue) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
	pq[i].index = i
	pq[j].index = j
}

func (pq *PriorityQueue) Push(x interface{}) {
	n := len(*pq)
	item := x.(*NewNode)
	item.index = n
	*pq = append(*pq, item)
}

func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)
	item := old[n-1]
	item.index = -1 // for safety
	*pq = old[0 : n-1]
	return item
}

// update modifies the priority and value of an Item in the queue.
func (pq *PriorityQueue) update(item *NewNode, accW int64, qIdx int32) {
	item.accW = accW
	item.qIdx = qIdx
	heap.Fix(pq, item.index)
}

type NewNode struct {
	accW  int64
	qIdx  int32
	index int
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 1024*1024)

	stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 1024*1024)

	nTemp, err := strconv.ParseInt(readLine(reader), 10, 64)
	checkError(err)
	n := int32(nTemp)

	wTemp := strings.Split(readLine(reader), " ")

	var w []int64

	for i := 0; i < int(n); i++ {
		wItem, err := strconv.ParseInt(wTemp[i], 10, 64)
		checkError(err)
		w = append(w, wItem)
	}

	mTemp, err := strconv.ParseInt(readLine(reader), 10, 64)
	checkError(err)
	m := int32(mTemp)

	queries := make([]string, m)
	for i := int32(0); i < m; i++ {
		queries[i] = readLine(reader)
	}

	result := cyclicalQueries(w, m, queries)

	for i, resultItem := range result {
		fmt.Fprintf(writer, "%d", resultItem)

		if i != len(result)-1 {
			fmt.Fprintf(writer, "\n")
		}
	}

	fmt.Fprintf(writer, "\n")

	writer.Flush()
}

func readLine(reader *bufio.Reader) string {
	str, _, err := reader.ReadLine()
	if err == io.EOF {
		return ""
	}

	return strings.TrimRight(string(str), "\r\n")
}

func checkError(err error) {
	if err != nil {
		panic(err)
	}
}
