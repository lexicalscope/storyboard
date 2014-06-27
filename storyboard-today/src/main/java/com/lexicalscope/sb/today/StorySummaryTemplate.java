package com.lexicalscope.sb.today;

import com.lexicalscope.sb.values.data.Relevance;
import com.lexicalscope.sb.values.data.Summary;
import com.lexicalscope.sb.values.data.Title;
import com.lexicalscope.sb.values.user.Name;

public interface StorySummaryTemplate {
   void id(long id);
   void title(Title title);
   void author(Name author);
   void summary(Summary summary);
   void relevance(Relevance relevance);

   void showGoldBadge();
   void showSilverBadge();
   void showBronzeBadge();
}
