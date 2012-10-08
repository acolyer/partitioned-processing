Cloud Bursting / Partitioned Processing Sample
============================

The order-processing project represents an orders system in which orders are
normally processed in your data center, but may be switched to be processed
in another location (in this case, Amazon EU West) on command. For example,
when experiencing heavy load, or on a set schedule to match traffic
patterns. Deploy with -Dspring.profiles.active="hq" to simulate what would
happen in the corporate data center, and -Dspring.profiles.active="cloud" to
set up the remote cloud processing capability.

The 'big switch' project changes the location of order processing atomically
at runtime by adding and removing an exchange binding from the local
(corporate HQ) exchange to a proxy for the remote cloud exchange. 

See scripts/s1-burst.conf for a setup to run the demo. See
etc/rabbitmq/*.config for details of the configuration of the rabbitmq
brokers for the upstream_sets and connections. 
