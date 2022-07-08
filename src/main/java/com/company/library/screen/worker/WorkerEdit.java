package com.company.library.screen.worker;

import io.jmix.ui.screen.*;
import com.company.library.entity.Worker;

@UiController("Worker.edit")
@UiDescriptor("worker-edit.xml")
@EditedEntityContainer("workerDc")
public class WorkerEdit extends StandardEditor<Worker> {
}