---
layout: inner
title: Getting Started Tutorial 3.x<br>Load the Product Data As-Is
lead_text: ''
permalink: /tutorial/load-products-as-is/
---

## Ingest Product Data As-Is

In this exercise, you will configure and execute an input flow to load product data.

The QuickStart input flow wizard enables you to quickly start loading data without learning the intricacies of the underlying tools. When you run your flow, QuickStart loads data into MarkLogic using [MarkLogic Content Pump](https://docs.marklogic.com/guide/mlcp){:target="_blank"} (mlcp). The mlcp command line tool can be used to import large amounts of data into MarkLogic, among other things. 

We will configure the flow to do the following:

* Load data from the sample data directory input/product.
* Interpret the input data as delimited text (CSV).
* Automatically generate unique URIs as the data is loaded, rather than basing the URIs on the first field in each row. This prevents one document from overwriting another if multiple rows contain the same value in the first field.

Use the following steps to configure the "Load Products" input flow, and then load the sample product data into MarkLogic:

1. Click **Load Products** under **Input Flows**. The Run Input Flow wizard appears.
1. Under **Input Files**, use the file browser to select the **input/products** directory.

    ![Input Files]({{site.baseurl}}/images/3x/load-products-as-is/input-files.png){:.screenshot-border}

1. Under **General Options**, change **Input File Type** to **Delimited Text**.

    ![General Options]({{site.baseurl}}/images/3x/load-products-as-is/general-options.png)
    
1. Under **Delimited Text Options**, slide the **Generate URI?** slider to the right so MarkLogic will generate a unique URI for each document you load. 
    
    ![Delimited Text Options]({{site.baseurl}}/images/3x/load-products-as-is/delimited-text-options.png)

1. Scroll to the bottom of the wizard and click **SAVE OPTIONS**.
1. Click **RUN IMPORT**. MarkLogic begins loading data. QuickStart displays a progress bar at the bottom of your browser.

When the load finishes, QuickStart displays a completion notification at the bottom of your browser.

## Review Your Finished Job

Use the QuickStart job viewer to view the results of previously run jobs. This interface offers <strong>free-text search</strong> and <strong>faceted navigation</strong>.

Click **Jobs** in the top navigation bar to open the job viewer:

![Click Jobs]({{site.baseurl}}/images/3x/load-products-as-is/select-jobs.png)

You should see a view similar to the following, reflecting the Load Products job we just completed:

![Jobs View]({{site.baseurl}}/images/3x/load-products-as-is/jobs-view.png)

Click **&gt;_** to inspect the output from your Load Products job. This output was generated by the mlcp command line tool. If the job completed successfully, you should see **OUTPUT_RECORDS_COMMITTED: 450** in the output. For example:

![MLCP Output]({{site.baseurl}}/images/3x/load-products-as-is/mlcp-output.png){:.screenshot-border}

Click the **x** icon to close the dialog.

## Inspect the Trace Logs for your Job

Tracing is a debugging feature that logs inputs and outputs to each of the plugins that run during a flow. This feature is useful for helping you see where along the chain something may have gone wrong.

To view the trace output from your Load Products job, click the **lightning bolt** icon (<i class="fa fa-bolt"></i>) on the far right of the job row. Alternatively, you can click **Traces** in the top navigation bar to see all traces.

![Click Lightning Bolt]({{site.baseurl}}/images/3x/load-products-as-is/click-lightning-bolt.png){:.screenshot-border}

Click one of the rows in the Traces table to see the trace detail view. At the top of the detailed view, you see information about this trace, including the **identifier** whose processing generated it.

You also see a flow diagram that enables you to examine the inputs and outputs for each stage of the flow. Each box in the diagram represents a plugin that handles a stage of the flow. When you click on a box, the input to and output from that plugin is displayed, along with that plugin's execution time.

![Trace Detail View]({{site.baseurl}}/images/3x/load-products-as-is/trace-details.png){:.screenshot-border}

## Up Next

[Browse and Understand the Product Data](../browse-understand-product-data/)