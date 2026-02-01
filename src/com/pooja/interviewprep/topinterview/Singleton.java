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
/*
•	Private constructor → prevents direct instantiation from outside.
•	Static instance → holds the single object of the class.
•	Public static method → provides access to the instance.
A Singleton class in Java is a design pattern that ensures only one instance of the class is created during the lifetime of the application, and it provides a global access point to that instance.
Types of Singleton Implementations:
•	Eager Initialization – instance created at class loading.
•	Lazy Initialization – instance created only when needed.
•	Thread-Safe Singleton – use synchronized to handle multi-threading.
•	Bill Pugh Singleton – uses static inner helper class (best practice).
•	Enum Singleton – simplest and prevents reflection/serialization issues.
	Eager → simple but wastes memory if instance not used.
	Lazy → saves memory but not thread-safe by default.
	Thread-Safe (sync) → safe, but slower.
	Bill Pugh → best for real-world, efficient and safe.
	Enum → ultimate safety, but less flexible (can’t extend classes).

Java guarantees:
Class initialization happens once
Initialization is atomic
Happens before any thread accesses it
So this line:
private static final BillPughSingleton INSTANCE = new BillPughSingleton();
is implicitly synchronized by JVM
“Initialization is atomic” means:
The JVM completes class initialization as one indivisible operation — no other thread can see it in a half-initialized state.
Let’s explain this clearly, simply, and interview-ready 👇
🔹 What “Atomic” Means (in simple terms)
Atomic = All or Nothing
Either the operation completes fully
Or it has not happened at all


🥇 WHY Enum Singleton is the BEST
1.Thread-Safe by JVM
Enum instances are created during class loading
JVM guarantees class initialization is atomic & thread-safe
No synchronized, no volatile, no locks
👉 Even with 100 threads:
EnumSingleton.INSTANCE
will always return the same object
2️.Protected from Reflection (BIGGEST ADVANTAGE) 🔒
❌ Normal singleton can be broken:
Constructor<Singleton> c = Singleton.class.getDeclaredConstructor();
c.setAccessible(true);
Singleton s2 = c.newInstance(); // ❌ New instance created
✅ Enum singleton:
Constructor<?>[] c = EnumSingleton.class.getDeclaredConstructors();
c[0].setAccessible(true);
c[0].newInstance(); // 💥 Exception
📌 JVM throws:
IllegalArgumentException: Cannot reflectively create enum objects
✔️ Reflection-safe by design
3️.Serialization-Safe (No extra code needed) 💾
❌ Normal Singleton:
readResolve() required to avoid new instance
✅ Enum Singleton:
JVM ensures same instance returned
No readResolve() needed
4️.Prevents Cloning
Enums cannot be cloned
JVM blocks it automatically
5️.Simplest & Cleanest Code
Compare:
❌ Bill Pugh:
private static class Helper {
    private static final Singleton INSTANCE = new Singleton();
}
✅ Enum:
INSTANCE;
Less code = fewer bugs 💯
In enum singleton, the enum constant itself is the singleton instance, so no factory or getInstance() method is required
“Because enum constants are implicitly public static final instances created once by JVM, we directly access them using EnumSingleton.INSTANCE.”
*/

