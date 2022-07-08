package com.company.library.screen.worker;

import io.jmix.ui.screen.*;
import com.company.library.entity.Worker;

@UiController("Worker.browse")
@UiDescriptor("worker-browse.xml")
@LookupComponent("workersTable")
public class WorkerBrowse extends StandardLookup<Worker> {
}