/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package finalodev;

import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * @author katana
 */
public class GUI extends javax.swing.JFrame {

    int selectionCounter = 0;
    int mergeCounter = 0;
    int bubbleCounter = 0;
    int insertionCounter = 0;
    int quickCounter = 0;
    int heapCounter = 0;

    /**
     * Creates new form GUI
     */
    int[] intArray;

    public GUI() {
        initComponents();

    }

    void initializeArray() {

        int lng = Integer.parseInt(arrayL.getText());

        Random r = new Random();

        intArray = new int[lng];

        for (int i = 0; i < intArray.length; i++) {

            int randomNum = r.nextInt(1000);

            intArray[i] = randomNum;

        }

    }

    void setGui(String type, String best, String average, String worst, int step) {

        String s = "";
        for (int i = 0; i < intArray.length; i++) {

            s += intArray[i] + " ";

        }

        sortedLabel.setText("Sorted Array: " + s);
        steps.setText("How Many Steps: " + step);
        algorithmNameLabel.setText(type);
        bestLabel.setText(best);
        averageLabel.setText(average);
        worstLabel.setText(worst);

    }

    void selectionSort() {

        for (int i = 0; i < intArray.length - 1; i++) {

            int min_index = i;

            for (int j = i + 1; j < intArray.length; j++) {

                if (intArray[j] < intArray[min_index]) {
                    min_index = j;

                }
                selectionCounter += 2;
            }

            int tmp = intArray[i];
            intArray[i] = intArray[min_index];
            intArray[min_index] = tmp;
            selectionCounter += 4;
        }

        setGui("Selection Sort", "O(n^2)", "O(n^2)", "O(n^2)", selectionCounter);

    }

    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged

        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
        mergeCounter += 4;
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
            mergeCounter++;
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
            mergeCounter++;

        }

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        mergeCounter += 2;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;

            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
            mergeCounter++;

        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
            mergeCounter++;

        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            mergeCounter++;

        }
    }

    void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
            mergeCounter++;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
        setGui("Merge Sort", "O(n log(n))", "O(n log(n))", "O(n log(n))", mergeCounter);

    }

    void bubbleSort() {

        for (int i = 0; i < intArray.length - 1; i++) {

            for (int j = 0; j < intArray.length - 1; j++) {

                if (intArray[j] > intArray[j + 1]) {

                    int tmp = intArray[j];
                    intArray[j] = intArray[j + 1];
                    intArray[j + 1] = tmp;

                }
                bubbleCounter += 4;
            }
            bubbleCounter++;
        }

        setGui("Bubble Sort", "O(n)", "O(n^2)", "O(n^2)", bubbleCounter);
    }

    void insertionSort() {

        for (int i = 1; i < intArray.length; i++) {

            int j = i - 1;

            while (j >= 0 && intArray[j + 1] < intArray[j]) {

                int tmp = intArray[j + 1];
                intArray[j + 1] = intArray[j];
                intArray[j] = tmp;
                j--;
                insertionCounter += 4;
            }
            insertionCounter++;
        }

        setGui("Insertion Sort", "O(n)", "O(n^2)", "O(n^2)", insertionCounter);

    }

    void quickSort(int array[], int start, int end) {

        if (end <= start) {
            quickCounter++;
            return;

        }

        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);

        setGui("Quick Sort", "O(n log(n))", "O(n log(n))", "O(n^2)", quickCounter);
    }

    int partition(int array[], int start, int end) {

        int pivot = array[end];
        int i = start - 1;
        quickCounter += 2;
        for (int j = start; j <= end - 1; j++) {

            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                quickCounter += 6;
            }

        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;
        quickCounter += 4;

        return i;
    }

    void heapSort(int arr[]) {
        int N = arr.length;
        heapCounter++;
        for (int i = N / 2 - 1; i >= 0; i--) {
            heapify(arr, N, i);
            heapCounter++;
        }

        for (int i = N - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapCounter += 3;

            heapify(arr, i, 0);
        }

        setGui("Heap Sort", "O(n log(n))", "O(n log(n))", "O(n log(n))", heapCounter);

    }

    void heapify(int arr[], int N, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        heapCounter += 3;
        if (l < N && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < N && arr[r] > arr[largest]) {
            largest = r;
        }
        heapCounter++;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapCounter += 3;
            heapify(arr, N, largest);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        arrayL = new javax.swing.JTextField();
        sortedLabel = new javax.swing.JLabel();
        algorithmNameLabel = new javax.swing.JLabel();
        sortedLabel2 = new javax.swing.JLabel();
        sortedLabel3 = new javax.swing.JLabel();
        averageLabel = new javax.swing.JLabel();
        sortedLabel5 = new javax.swing.JLabel();
        bestLabel = new javax.swing.JLabel();
        sortedLabel7 = new javax.swing.JLabel();
        worstLabel = new javax.swing.JLabel();
        sortsComboBox = new javax.swing.JComboBox<>();
        sortButton = new javax.swing.JButton();
        steps = new javax.swing.JLabel();
        cizdir = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel1.setText("Array Size:");

        sortedLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        sortedLabel.setText("Sorted Array:");

        algorithmNameLabel.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        algorithmNameLabel.setText("\"Algorithm Name\"");

        sortedLabel2.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        sortedLabel2.setText("Complexity");

        sortedLabel3.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        sortedLabel3.setText("Best");

        averageLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        averageLabel.setText("Average");

        sortedLabel5.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        sortedLabel5.setText("Worst");

        bestLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        bestLabel.setText("Best");

        sortedLabel7.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        sortedLabel7.setText("Average");

        worstLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        worstLabel.setText("Worst");

        sortsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selection Sort", "Bubble Sort", "Insertion Sort", "Merge Sort", "Quick Sort", "Heap Sort" }));
        sortsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortsComboBoxActionPerformed(evt);
            }
        });

        sortButton.setText("Sort");
        sortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortButtonActionPerformed(evt);
            }
        });

        steps.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        steps.setText("How Many Steps: ");

        cizdir.setText("Cizdir");
        cizdir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cizdirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sortedLabel)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(steps, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(28, 28, 28)
                                    .addComponent(arrayL, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(117, 117, 117)
                                    .addComponent(sortsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(51, 51, 51)
                            .addComponent(sortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(algorithmNameLabel)
                            .addComponent(sortedLabel2))
                        .addGap(137, 137, 137)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bestLabel)
                            .addComponent(sortedLabel3))
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sortedLabel7)
                            .addComponent(averageLabel))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sortedLabel5)
                            .addComponent(worstLabel)))
                    .addComponent(cizdir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(arrayL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sortsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sortButton))
                    .addComponent(jLabel1))
                .addGap(62, 62, 62)
                .addComponent(sortedLabel)
                .addGap(18, 18, 18)
                .addComponent(steps)
                .addGap(131, 131, 131)
                .addComponent(cizdir)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortedLabel3)
                    .addComponent(sortedLabel5)
                    .addComponent(algorithmNameLabel)
                    .addComponent(sortedLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortedLabel2)
                    .addComponent(bestLabel)
                    .addComponent(averageLabel)
                    .addComponent(worstLabel))
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sortsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sortsComboBoxActionPerformed

    private void sortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortButtonActionPerformed
        String text = (String) sortsComboBox.getSelectedItem();

        initializeArray();

        switch (text) {

            case "Selection Sort":
                selectionCounter = 0;
                selectionSort();
                break;
            case "Bubble Sort":
                bubbleCounter = 0;
                bubbleSort();
                break;
            case "Quick Sort":
                quickCounter = 0;
                quickSort(intArray, 0, intArray.length - 1);
                break;
            case "Merge Sort":
                mergeCounter = 0;
                mergeSort(intArray, 0, intArray.length - 1);
                break;
            case "Insertion Sort":
                insertionCounter = 0;
                insertionSort();
                break;
            case "Heap Sort":
                heapCounter = 0;
                heapSort(intArray);
                break;
        }

    }//GEN-LAST:event_sortButtonActionPerformed

    private void cizdirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cizdirActionPerformed

        initializeArray();

        int array[] = intArray;

        heapSort(intArray);;

        intArray = array;

        insertionSort();

        intArray = array;

        mergeSort(intArray, 0, intArray.length - 1);

        intArray = array;

        quickSort(intArray, 0, intArray.length - 1);

        intArray = array;

        bubbleSort();

        intArray = array;

        selectionSort();

        BarChart panel = new BarChart(insertionCounter, heapCounter, bubbleCounter,
                selectionCounter, quickCounter, mergeCounter);
        JFrame jf = new JFrame();

        jf.add(panel);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // jf.setLocationRelativeTo(null);
        jf.setSize(500, 500);
        jf.setVisible(true);
    }//GEN-LAST:event_cizdirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel algorithmNameLabel;
    private javax.swing.JTextField arrayL;
    private javax.swing.JLabel averageLabel;
    private javax.swing.JLabel bestLabel;
    private javax.swing.JButton cizdir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton sortButton;
    private javax.swing.JLabel sortedLabel;
    private javax.swing.JLabel sortedLabel2;
    private javax.swing.JLabel sortedLabel3;
    private javax.swing.JLabel sortedLabel5;
    private javax.swing.JLabel sortedLabel7;
    private javax.swing.JComboBox<String> sortsComboBox;
    private javax.swing.JLabel steps;
    private javax.swing.JLabel worstLabel;
    // End of variables declaration//GEN-END:variables
}
