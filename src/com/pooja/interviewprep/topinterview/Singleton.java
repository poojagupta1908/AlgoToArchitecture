package com.pooja.interviewprep.topinterview;

public class Singleton {

        public static void main(String[] args) {
            System.out.println("Singleton Classes");

            // Eager Singleton
            EagerInitializationSingleton eager1 = EagerInitializationSingleton.getInstance();
            EagerInitializationSingleton eager2 = EagerInitializationSingleton.getInstance();
            System.out.println("Eager Singleton same instance: " + (eager1 == eager2));

            // Lazy Singleton
            LazyInitializationSingleton lazy1 = LazyInitializationSingleton.getInstance();
            LazyInitializationSingleton lazy2 = LazyInitializationSingleton.getInstance();
            System.out.println("Lazy Singleton same instance: " + (lazy1 == lazy2));

            // ThreadSafe Singleton
            ThreadSafeSingleton threadSafe1 = ThreadSafeSingleton.getInstance();
            ThreadSafeSingleton threadSafe2 = ThreadSafeSingleton.getInstance();
            System.out.println("ThreadSafe Singleton same instance: " + (threadSafe1 == threadSafe2));

            // BullPughSingleton Singleton
            BullPughSingleton bull1 = BullPughSingleton.getInstance();
            BullPughSingleton bull2 = BullPughSingleton.getInstance();
            System.out.println("Lazy Singleton same instance: " + (bull1 == bull2));

            //enum Singleton
            EnumSingleton enum1 = EnumSingleton.INSTANCE;
            EnumSingleton enum2 = EnumSingleton.INSTANCE;
            System.out.println("Enum Singleton same instance: " + (enum1 == enum2));
        }

        static class EagerInitializationSingleton {
            private static final EagerInitializationSingleton instance = new EagerInitializationSingleton();

            private EagerInitializationSingleton() {
            }

            public static EagerInitializationSingleton getInstance() {
                return instance;
            }
        }

        static class LazyInitializationSingleton {
            private static LazyInitializationSingleton instance;

            private LazyInitializationSingleton() {
            }

            public static LazyInitializationSingleton getInstance() {
                if (instance == null) {
                    instance = new LazyInitializationSingleton();
                }
                return instance;
            }
        }

        static class ThreadSafeSingleton {
            private static ThreadSafeSingleton instance;

            private ThreadSafeSingleton() {
            }

            public static synchronized ThreadSafeSingleton getInstance() {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
                return instance;
            }
        }

        static class BullPughSingleton {
            private BullPughSingleton() {
            }

            //static inner class
            private static class SingletonHelper {
                private static final BullPughSingleton INSTANCE = new BullPughSingleton();
            }

            public static BullPughSingleton getInstance() {
                return SingletonHelper.INSTANCE;
            }
        }

        enum EnumSingleton {
            INSTANCE;

            public void showMessage() {
                System.out.println("Hello from Enum Singleton");
            }
        }
    }


