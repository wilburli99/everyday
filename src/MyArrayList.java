import java.util.Arrays;

public class MyArrayList {
    public class MyArraylist {

        public int[] elem;
        public int usedSize;//0
        //默认容量
        private static final int DEFAULT_SIZE = 10;

        public MyArraylist() {
            this.elem = new int[DEFAULT_SIZE];
        }

        /**
         * 打印顺序表:
         * 根据usedSize判断即可
         */
        public void display() {
            for (int i = 0; i < this.usedSize; i++) {
                System.out.println(this.elem[i]);
            }
            System.out.println();
        }

        // 新增元素,默认在数组最后新增
        public void add(int data) {
            // 判断数组是否已满
            if (isFull()) {
                // 扩容
                this.elem = Arrays.copyOf(elem, 2 * this.elem.length);
            }
            this.elem[usedSize] = data;
            this.usedSize++;
        }

        /**
         * 判断当前的顺序表是不是满的！
         *
         * @return true:满   false代表空
         */
        public boolean isFull() {
            if (usedSize == this.elem.length) {
                return true;
            }
            return false;
        }


        private boolean checkPosInAdd(int pos) {
            if (pos < 0 || pos > this.usedSize) {
                return false;
            }
            return true;//合法
        }

        // 在 pos 位置新增元素
        public void add(int pos, int data) {
            // 判断数组是否满了
            if (this.isFull()) {
                this.elem = Arrays.copyOf(elem, 2 * this.elem.length);
            }
            // 如果pos位置在最后尾，则直接在末尾添加
            if (pos == usedSize) {
                add(data);
            }
            if (checkPosInAdd(pos)) {
                for (int i = this.usedSize - 1; i >= pos; i--) {
                    this.elem[i + 1] = this.elem[i];
                }
                this.elem[pos] = data;
                this.usedSize++;
            }
        }

        // 判定是否包含某个元素
        public boolean contains(int toFind) {
            for (int i = 0; i < this.usedSize; i++) {
                if (this.elem[i] == toFind) {
                    return true;
                }
            }
            return false;
        }

        // 查找某个元素对应的位置
        public int indexOf(int toFind) {
            for (int i = 0; i < this.usedSize; i++) {
                if (this.elem[i] == toFind) {
                    return i;
                }
            }
            return -1;
        }
        // 获取 pos 位置的元素
        public int get(int pos) {
            if (!checkPosInAdd(pos)) {
                System.out.println("pos位置不合法");
            }
            if (isEmpty()) {
                System.out.println("数组为空");
            }
            return this.elem[pos];
        }

        private boolean isEmpty() {
            if (this.usedSize == 0) {
                return true;
            }
            return false;
        }

        // 给 pos 位置的元素设为【更新为】 value
        public void set(int pos, int value) {
            if (!checkPosInAdd(pos)) {
                System.out.println("位置不合法");
            }
            this.elem[pos] = value;
        }

        /**
         * 删除第一次出现的关键字key
         *
         * @param key
         */
        public void remove(int key) {
            if (isEmpty()) {
                System.out.println("顺序表为空");
            }
            int index = indexOf(key);
            if (index == -1) {
                System.out.println("没有这个元素");
            }
            for (int i = index; i < this.usedSize; i++) {
                this.elem[i] = this.elem[i + 1];
            }
            this.usedSize--;
        }

        // 获取顺序表长度
        public int size() {
            return this.usedSize;
        }

        // 清空顺序表
        public void clear() {
            this.usedSize = 0;
        }
    }
}
