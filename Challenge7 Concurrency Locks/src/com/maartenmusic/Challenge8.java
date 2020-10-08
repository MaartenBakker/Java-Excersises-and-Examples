package com.maartenmusic;

import java.util.concurrent.locks.ReentrantLock;

public class Challenge8 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Tutor tutor = new Tutor();
        tutor.setLock(lock);
        Student student = new Student(tutor);
        student.setLock(lock);
        tutor.setStudent(student);

        Thread tutorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                tutor.studyTime();
            }
        });

        Thread studentThread = new Thread(new Runnable() {
            @Override
            public void run() {
                student.handInAssignment();
            }
        });

        tutorThread.start();
        studentThread.start();
        }
    }

    class Tutor {
        private Student student;
        private ReentrantLock lock;

        public synchronized void setStudent(Student student) {
            this.student = student;
        }

        public synchronized void setLock(ReentrantLock lock) {
            this.lock = lock;
        }

        public void studyTime() {
            System.out.println("Tutor has arrived");
            try {
                // wait for student to arrive and hand in assignment
                Thread.sleep(300);
            }
            catch (InterruptedException e) {

            }
            lock.lock();
            try {
                student.startStudy();
            } finally {
                lock.unlock();
            }
            System.out.println("Tutor is studying with student");
        }

        public void getProgressReport() {
            // get progress report
            System.out.println("Tutor gave progress report");
        }
    }

    class Student {

        private Tutor tutor;
        private ReentrantLock lock;

        Student(Tutor tutor) {
            this.tutor = tutor;
        }

        public synchronized void setLock(ReentrantLock lock) {
            this.lock = lock;
        }

        public void startStudy() {
            // study
            System.out.println("Student is studying");
        }

        public void handInAssignment() {
            lock.lock();
            try {
                tutor.getProgressReport();
            } finally {
                lock.unlock();
            }
            System.out.println("Student handed in assignment");
        }

}
