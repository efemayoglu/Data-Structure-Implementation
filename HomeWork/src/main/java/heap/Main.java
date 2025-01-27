package heap;


class MinMaxHeap {
        private int[] Heap;
        private int size;
        private int maxsize;

        private static final int FRONT = 1;

        public MinMaxHeap(int maxsize)
        {
            this.maxsize = maxsize;
            this.size = 0;
            Heap = new int[this.maxsize + 1];
            Heap[0] = Integer.MIN_VALUE;
        }
    public MinMaxHeap(int maxsize,int type)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

        // Function to return the position of
        // the parent for the node currently
        // at pos
        private int parent(int pos)
        {
            return pos / 2;
        }

        // Function to return the position of the
        // left child for the node currently at pos
        private int leftChild(int pos)
        {
            return (2 * pos);
        }

        // Function to return the position of
        // the right child for the node currently
        // at pos
        private int rightChild(int pos)
        {
            return (2 * pos) + 1;
        }

        // Function that returns true if the passed
        // node is a leaf node
        private boolean isLeaf(int pos)
        {
            if (pos >= (size / 2) && pos <= size) {
                return true;
            }
            return false;
        }

        // Function to swap two nodes of the heap
        private void swap(int fpos, int spos)
        {
            int tmp;
            tmp = Heap[fpos];
            Heap[fpos] = Heap[spos];
            Heap[spos] = tmp;
        }
        public void add(int element)
        {
            Heap[++size] = element;

            // Traverse up and fix violated property
            int current = size;
            while (Heap[current] > Heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }
        public void display()
        {
            for (int i = 1; i <= size / 2; i++) {
                System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " +
                        Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
                System.out.println();
            }
        }
        public int poll()
        {
            int popped = Heap[1];
            Heap[1] = Heap[size--];
            maxHeapify(1);
            return popped;
        }

        private void maxHeapify(int pos)
        {
            if (isLeaf(pos))
                return;

            if (Heap[pos] < Heap[leftChild(pos)] ||
                    Heap[pos] < Heap[rightChild(pos)]) {

                if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                }
                else {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }

        // Function to heapify the node at pos
        private void minHeapify(int pos)
        {

            // If the node is a non-leaf node and greater
            // than any of its child
            if (!isLeaf(pos)) {
                if (Heap[pos] > Heap[leftChild(pos)]
                        || Heap[pos] > Heap[rightChild(pos)]) {

                    // Swap with the left child and heapify
                    // the left child
                    if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                        swap(pos, leftChild(pos));
                        minHeapify(leftChild(pos));
                    }

                    // Swap with the right child and heapify
                    // the right child
                    else {
                        swap(pos, rightChild(pos));
                        minHeapify(rightChild(pos));
                    }
                }
            }
        }

        // Function to insert a node into the heap
        public void insert(int element)
        {
            if (size >= maxsize) {
                return;
            }
            Heap[++size] = element;
            int current = size;

            while (Heap[current] < Heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

        // Function to print the contents of the heap
        public void print()
        {
            for (int i = 1; i <= size / 2; i++) {
                System.out.print(" PARENT : " + Heap[i]
                        + " LEFT CHILD : " + Heap[2 * i]
                        + " RIGHT CHILD :" + Heap[2 * i + 1]);
                System.out.println();
            }
        }

        // Function to build the min heap using
        // the minHeapify
        public void minHeap()
        {
            for (int pos = (size / 2); pos >= 1; pos--) {
                minHeapify(pos);
            }
        }

        // Function to remove and return the minimum
        // element from the heap
        public int remove()
        {
            int popped = Heap[FRONT];
            Heap[FRONT] = Heap[size--];
            minHeapify(FRONT);
            return popped;
        }

        // Driver code
        public static void main(String[] arg)
        {
            System.out.println("The Min Heap is ");
            MinMaxHeap minHeap = new  MinMaxHeap(15);
            minHeap.insert(5);
            minHeap.insert(3);
            minHeap.insert(17);
            minHeap.insert(10);
            minHeap.insert(84);
            minHeap.insert(19);
            minHeap.insert(6);
            minHeap.insert(22);
            minHeap.insert(9);

            minHeap.minHeap();
            minHeap.print();

            System.out.println("The Min val is " + minHeap.remove());

          /*  MinMaxHeap maxHeap = new MinMaxHeap(20,0);
            maxHeap.add(15);
            maxHeap.add(13);
            maxHeap.add(7);
            maxHeap.add(5);
            maxHeap.add(52);
            maxHeap.add(23);
            maxHeap.add(16);
            maxHeap.add(9);
            maxHeap.add(21);

            maxHeap.display();
            System.out.println("The max val is " + maxHeap.poll());*/

        }
        class RedBlackTree{
            public RedBlackTree(){

            }
            public void insert(){

            }
            public void printTree(){

            }
        }
}
