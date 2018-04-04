package huffman;

/**
 * Author : ZhangYuHui
 * Date : 2018/3/2
 * TODO :哈夫曼节点类
 */
public class HuffManBean {
    //数据域
    private int data;
    //索引
    private int index;
    //左子节点
    private HuffManBean left;
    //右子节点
    private HuffManBean right;

    //哈夫曼节点的构造函数
    public HuffManBean(int data,int index){
        this.data=data;
        this.index=index;
    }

    //私有属性的封装
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public HuffManBean getLeft() {
        return left;
    }
    public void setLeft(HuffManBean left) {
        this.left = left;
    }
    public HuffManBean getRight() {
        return right;
    }
    public void setRight(HuffManBean right) {
        this.right = right;
    }

}
