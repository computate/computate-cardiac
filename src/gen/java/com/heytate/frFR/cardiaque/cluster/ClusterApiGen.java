package com.heytate.frFR.cardiaque.cluster;

import javax.servlet.http.HttpServlet;
import java.lang.Long;
import com.heytate.frFR.cardiaque.contexte.EcouteurContexte;
import com.heytate.frFR.cardiaque.page.MiseEnPage;
import com.heytate.frFR.cardiaque.requete.RequeteSite;
import java.time.LocalDateTime;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import com.heytate.frFR.cardiaque.cluster.Cluster;
import com.heytate.frFR.cardiaque.couverture.Couverture;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.client.solrj.SolrClient;

public abstract class ClusterApiGen extends HttpServlet {
}
