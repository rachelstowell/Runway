# Runway

This program simulates a small airport with a single runway for both landing and take off. 
There are two queues; one queue is of planes waiting to land, the other queue is of planes 
waiting to take off. Only one plane can use the runway at a time. All takeoffs take the 
same amount of time. All landings take the same amount of time, but this does not have to 
be the same amount of time to takeoff. Planes arrive for landing at random times but with
a specific probability of of a plane arriving during any given minute. Similarly, planes 
arrive at the takeoff queue at random times but with a (possibly different) specified 
probability oof a departure. Landings have priority over takeoffs since it is more dangerous
and expensive to keep a plane waiting to land than it is to keep a plane waiting to take off.
As long as a plane is waiting to land, no plane can takeoff. An integer variable represents
a clock to count the number of minutes simulated. A random number generator is used to simulate
arrival and departure times of airplanes. All planes can remain in the queue for the same amount
of time before they run out of fuel. If a plane runs out of fuel, it is recorded as a crash. 


I. The Input

a) The amount of time needed for one plane to land
b) The amount of time needed for one plane to takeoff
c) The probability of a plane arriving to land during a minute
d) The average amount of time between arrival of planes to the landing queue
e) The probability of a plane arriving to take off during a minute
f) The average amount of time between arrival of planes to the takeoff queue
g) The maximum amount of time that a plane can stay in the landing queue without running out of fuel
h) The total length of time to be simulated


II. The Output

a) The number of planes that took off in the simulated time
b) The number of planes that landed in the simulated time
c) The number of planes that crashed because they ran out of fuel before landing
d) The average time that a plane spent in the takeoff queue
e) The average time that a plane spent in the landing queue


III. An example

Sample Input/Output:

Amount of minutes to land: 4
Amount of minutes to take off: 2
Probability of arrival during a minute: 0.05
Average amount of time between planes to land: 20.0
Probability of departure during a minute: 0.05
Average amount of time between planes to take off: 20.0
Maximum amount of time in the air before crashing: 2
Total simulation minutes: 6000

Number of planes taken off: 322
Number of planes landed: 300
Number of planes crashed: 18
Average waiting time for taking off: 0.93 minutes
Average waiting time for landing: 0.21 minutes
