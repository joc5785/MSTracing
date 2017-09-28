# MSTracing
# Purpose:

This MS Tracing project is a proof of concept leveraging the Opentracing.io standard to provide distributed application tracing.  Opentracing provides a Spring library which is brought in through Maven.  In this particular application I have created 3 Rest microservices.

# Jaeger (Uber's Distributed Tracing Interface)

Running Jaeger Docker Image:
$ docker run -d -p 5775:5775/udp -p 16686:16686 jaegertracing/all-in-one:latest
