package com.marklogic.hub.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainModel {

	private String domainName;
	private List<FlowModel> inputFlows;
	private List<FlowModel> conformFlows;
	private boolean isSynched;

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public List<FlowModel> getInputFlows() {
		return inputFlows;
	}
	
	public Map<String, FlowModel> getInputFlowsAsMap() {
        Map<String, FlowModel> flowModels = new HashMap<>();
        
        if (inputFlows != null) {
            for (FlowModel model : inputFlows) {
                flowModels.put(model.getFlowName(), model);
            }
        }
        
        return flowModels;
    }

	public void setInputFlows(List<FlowModel> inputFlows) {
		this.inputFlows = inputFlows;
	}

	public List<FlowModel> getConformFlows() {
		return conformFlows;
	}
	
	public Map<String, FlowModel> getConformFlowsAsMap() {
	    Map<String, FlowModel> flowModels = new HashMap<>();
	    
	    if (conformFlows != null) {
	        for (FlowModel model : conformFlows) {
	            flowModels.put(model.getFlowName(), model);
	        }
	    }
	    
	    return flowModels;
	}

	public void setConformFlows(List<FlowModel> conformFlows) {
		this.conformFlows = conformFlows;
	}

	public boolean isSynched() {
		return isSynched;
	}

	public void setSynched(boolean isSynched) {
		this.isSynched = isSynched;
	}

	public void setInputFlowsSynched(boolean synched) {
	    if (inputFlows != null) {
	        for (FlowModel model : inputFlows) {
	            model.setSynched(synched);
	        }
	    }
	}
	
	public void setConformFlowsSynched(boolean synched) {
        if (conformFlows != null) {
            for (FlowModel model : conformFlows) {
                model.setSynched(synched);
            }
        }
    }
	
	public void copySyncStatusFrom(DomainModel oldModel) {
	    if (oldModel == null) {
	        return;
	    }
	    if (!domainName.equals(oldModel.getDomainName())) {
	        return;
	    }
	    
	    setSynched(oldModel.isSynched());
	    
	    Map<String, FlowModel> inputFlowModels = oldModel.getInputFlowsAsMap();
	    if (inputFlows != null) {
	        for (FlowModel model : inputFlows) {
	            FlowModel oldFlow = inputFlowModels.get(model.getFlowName());
	            if (oldFlow != null) {
	                model.setSynched(oldFlow.isSynched());
	            }
	        }
	    }
	    
	    Map<String, FlowModel> conformFlowModels = oldModel.getConformFlowsAsMap();
        if (conformFlows != null) {
            for (FlowModel model : conformFlows) {
                FlowModel oldFlow = conformFlowModels.get(model.getFlowName());
                if (oldFlow != null) {
                    model.setSynched(oldFlow.isSynched());
                }
            }
        }
	}
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("domainName=");
        sb.append(domainName);
        sb.append("isSynched=");
        sb.append(isSynched);
        sb.append("}");
        
        return sb.toString();
    }
}
